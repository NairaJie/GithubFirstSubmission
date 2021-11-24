package com.nailah.githubfirstsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.nailah.githubfirstsubmission.data.model.Users
import com.nailah.githubfirstsubmission.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding
    private lateinit var users: Users
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        users = intent.getParcelableExtra<Users>(EXTRA_USER) as Users
        showDetail()
    }

    private fun showDetail() {
        Glide.with(this).load(users.avatar).circleCrop()
            .into(detailBinding.ivDetail)
        detailBinding.tvFolower.text = users.follower.toString()
        detailBinding.tvFollowing.text = users.following.toString()
        detailBinding.tvNameDetail.text = users.name
        detailBinding.tvUserNamedetail.text = users.username
        detailBinding.tvCompany.text = users.company
        detailBinding.tvLocation.text = users.location
    }

    companion object{
        const val EXTRA_USER = "extra_user"
    }
}