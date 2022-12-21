package com.iliavolkov.popularlibraries.view.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iliavolkov.popularlibraries.databinding.FragmentUserBinding
import com.iliavolkov.popularlibraries.databinding.FragmentUsersListBinding
import com.iliavolkov.popularlibraries.model.GithubUser
import com.iliavolkov.popularlibraries.utils.BUNDLE_KEY_USER_INFO
import com.iliavolkov.popularlibraries.utils.OnBackPressedListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import kotlin.math.log

class UserFragment:MvpAppCompatFragment(),UserView,OnBackPressedListener {
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!
    private val presenter by moxyPresenter { UserPresenter() }
    private lateinit var user:GithubUser

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getInfoUser()

    }

    private fun getInfoUser() {
        arguments?.let {
            it.getParcelable<GithubUser>(BUNDLE_KEY_USER_INFO)?.let { item ->
                user = GithubUser(
                    item.login
                )
            }
        }
        binding.tvUserLogin.text = user.login
    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) = UserFragment().apply { arguments = bundle }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onBackPressed() = presenter.onBackPressed()
}