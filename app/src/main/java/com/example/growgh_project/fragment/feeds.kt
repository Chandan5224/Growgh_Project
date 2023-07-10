package com.example.growgh_project.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.growgh_project.FeedsAdapter
import com.example.growgh_project.databinding.FragmentFeedsBinding


const val BASE_URL = "https://hargrimm-wikihow-v1.p.rapidapi.com/images?count=10"

class feeds : Fragment() {

    lateinit var mAdapter: FeedsAdapter
    var urlList: ArrayList<String> = ArrayList()
    lateinit var binding: FragmentFeedsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFeedsBinding.inflate(layoutInflater, container, false)

        mAdapter = FeedsAdapter(requireContext())
        binding.recycleView.layoutManager = LinearLayoutManager(binding.root.context)
        binding.recycleView.adapter = mAdapter
        fetchData()
        binding.SwipeRefreshLayout.setOnRefreshListener {
            urlList.clear()
            fetchData()
            binding.SwipeRefreshLayout.isRefreshing = false
        }

        return binding.root
    }

    private fun fetchData() {
        val queue: RequestQueue = Volley.newRequestQueue(requireContext())
        binding.progressBar.visibility = View.VISIBLE
        binding.recycleView.visibility = View.GONE
        val request: JsonObjectRequest =
            object : JsonObjectRequest(Method.GET,
                BASE_URL,
                null,
                Response.Listener { response ->
                    Log.e("TAGG", response.getString("1"))
                    urlList.add(response.getString("1"))
                    urlList.add(response.getString("2"))
                    urlList.add(response.getString("3"))
                    urlList.add(response.getString("4"))
                    urlList.add(response.getString("5"))
                    urlList.add(response.getString("6"))
                    urlList.add(response.getString("7"))
                    urlList.add(response.getString("8"))
                    urlList.add(response.getString("9"))
                    urlList.add(response.getString("10"))
                    if (urlList.isNotEmpty()) {
                        mAdapter.updateList(urlList)
                    }
                    binding.progressBar.visibility = View.GONE
                    binding.recycleView.visibility = View.VISIBLE
                },
                Response.ErrorListener { error ->
                    error.message?.let { Log.e(tag, it) }
                }) {

                @Throws(AuthFailureError::class)
                override fun getHeaders(): Map<String, String> {
                    val headers = HashMap<String, String>()
                    headers["X-RapidAPI-Key"] = "bf54faac0amsh520138a9465e338p1dc94ejsn4bdd51875c5b"
                    headers["X-RapidAPI-Host"] = "hargrimm-wikihow-v1.p.rapidapi.com"
                    return headers
                }
            }
        queue.add(request)
    }
}
