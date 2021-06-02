package `in`.creativelizard.helpus.sos

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

@BindingAdapter("loadImage")
fun bindingImage(profileImageView: ShapeableImageView,imgUri:String){
    Glide.with(profileImageView.context).load(imgUri).into(profileImageView)
}
