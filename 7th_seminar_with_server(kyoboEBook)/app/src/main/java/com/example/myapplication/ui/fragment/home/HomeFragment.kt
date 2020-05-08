
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.ui.fragment.home.FindBook.FindBookAdapter
import com.example.myapplication.MainAdRvAdapter
import com.example.myapplication.Main_ad
import com.example.myapplication.R
import com.example.myapplication.api.RequestURL
import com.example.myapplication.data.GetTasteBookDataRes
import com.example.myapplication.data.PostFindBookDataRes
import com.example.myapplication.data.PostHashtagRes
import com.example.myapplication.ui.fragment.home.TasteBook.TasteBookAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private lateinit var rvMain : RecyclerView
    private lateinit var mAdapter: MainAdRvAdapter

    private lateinit var rvHomefindView: RecyclerView
    private lateinit var findBookAdapter: FindBookAdapter

    private lateinit var rvHometasteView: RecyclerView
    private lateinit var tasteBookAdapter: TasteBookAdapter

    var mainAdList = arrayListOf<Main_ad>(
        Main_ad("베스트 셀러를\n무제한으로 읽어보세요", "2개월 무료후 9,900원\n무한eBook서비스 최다 책 보유", "main_ad_img"),
        Main_ad("두번째 광고", "호호", "main_ad_img")
    )

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        rvMain = view.findViewById(R.id.rv_main_ad)
        mAdapter = MainAdRvAdapter(context!!, mainAdList)
        rvMain.adapter = mAdapter
        rvMain.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

         //PagerSnapHelper 추가
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvMain)

        getBookCategoryList(view)
        getBookLikeList(view)
        getHashtag(view)

        return view
    }

    //FindBook
    private fun getBookCategoryList(v: View){

        // 다른 것과 같이 메모리로 가져오자.
        rvHomefindView = v.findViewById(R.id.rv_home_Find)
        findBookAdapter = FindBookAdapter(context!!)
        // 우리의 recyclerView 에 우리의 adapter 로 세팅하자.
        rvHomefindView.adapter = findBookAdapter
        // viewHolder 들이 어떻게 배치될 지 설정하자.
        rvHomefindView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvHomefindView)

        val call: Call<PostFindBookDataRes> = RequestURL.service.getFindBookCategory("library")

        call.enqueue(
            object : Callback<PostFindBookDataRes>{
                override fun onFailure(call: Call<PostFindBookDataRes>, t: Throwable) {
                    Log.e("getBookCategoryList", "error: $t")
                }

                override fun onResponse(call: Call<PostFindBookDataRes>, response: Response<PostFindBookDataRes>) {
                    if(response.isSuccessful){
                        val findBookData = response.body()!!
                        Log.e("body", findBookData.toString())

                        // this 로 현재 context 를 전달하자.
                        findBookAdapter.data = findBookData.data
                        findBookAdapter.notifyDataSetChanged()

                    }
                }
            }
        )
    }

    //TasteBook
    private fun getBookLikeList(v: View){

        rvHometasteView = v.findViewById(R.id.rv_home_taste)
        tasteBookAdapter = TasteBookAdapter(context!!)
        rvHometasteView.adapter = tasteBookAdapter
        rvHometasteView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvHometasteView)

        val call: Call<GetTasteBookDataRes> = RequestURL.service.getTasteBookName("lee")

        call.enqueue(
            object : Callback<GetTasteBookDataRes>{
                override fun onFailure(call: Call<GetTasteBookDataRes>, t: Throwable) {
                    Log.e("getBookLikeList", "error:$t")
                }
                override fun onResponse(call: Call<GetTasteBookDataRes>, response: Response<GetTasteBookDataRes>
                ) {
                    if(response.isSuccessful){
                        val bookLikeData = response.body()!!
                        Log.e("body", bookLikeData.toString())

                        tasteBookAdapter.data = bookLikeData.data
                        tasteBookAdapter.notifyDataSetChanged()
                    }
                }
            }
        )
    }

    private fun getHashtag(v: View) {

        val call: Call<PostHashtagRes> = RequestURL.service.getHashtag("Sopt")

        call.enqueue(
            object : Callback<PostHashtagRes> {
                override fun onFailure(call: Call<PostHashtagRes>, t: Throwable) {
                    Log.e("getHashtag", "error:$t")
                }

                override fun onResponse(
                    call: Call<PostHashtagRes>,
                    response: Response<PostHashtagRes>
                ) {
                    if (response.isSuccessful) {
                        Log.e("sds", "Aaa" + response.body()!!)
                        Glide.with(this@HomeFragment)
                            .load(response.body()!!.data.hashtagImage)
                            .into(img_custom_keyword)
                        txt_hashtag.setText(response.body()!!.data.keyword)
                        txt_hashtag_main.setText(response.body()!!.data.mainKeyword)
                    }
                }

            }
        )
    }
/*
    private lateinit var rvMain : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //상단바(액션바)
        supportActionBar!!.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar!!.setCustomView(R.layout.top_menu)     //layout폴더 menu가 상단바 구성
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#255ad2")))        //상단바색깔


        val mAdapter = MainAdRvAdapter(this, mainadList)
        rv_main_ad.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        rv_main_ad.layoutManager = lm
        rv_main_ad.setHasFixedSize(true)
        lm.setOrientation(LinearLayoutManager.HORIZONTAL)  //수평 스크롤

        // PagerSnapHelper 추가
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rv_main_ad)

        initGitRepoList()
    }

    private fun initGitRepoList(){

        var mainadList = arrayListOf<Main_ad>()

    }*/

}
