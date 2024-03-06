package com.ingenieriajhr.pixelgame

import android.graphics.Bitmap
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.camera.core.ImageProxy
import androidx.core.content.ContextCompat
import com.ingenieriajhr.pixelgame.anim.Animations
import com.ingenieriajhr.pixelgame.anim.InterfaceListenerAnimation
import com.ingenieriajhr.pixelgame.databinding.ActivityMainBinding
import com.ingenieriajhr.pixelgame.fragments.FragmentNavigationManager
import com.ingenieriajhr.pixelgame.fragments.MainSelectFragment
import com.ingenieriiajhr.jhrCameraX.BitmapResponse
import com.ingenieriiajhr.jhrCameraX.CameraJhr
import com.ingenieriiajhr.jhrCameraX.ImageProxyResponse

class MainActivity : AppCompatActivity() {

    lateinit var vb:ActivityMainBinding

    //Animation Rotate
    lateinit var animations:Animations

    //Init cameraXJHR
    lateinit var cameraJhr: CameraJhr

    //late init fragment Navigation
    lateinit var fragmentNavigationManager: FragmentNavigationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        //change notification bar
        window.statusBarColor = ContextCompat.getColor(this,R.color.blue)
        //init animations
        animations = Animations(this)
        //aniamationRotateInit
        animationRotateInitial()
        //Init Camera Jhr
        cameraJhr = CameraJhr(this)
    }






    /**
     * Animation rotate Initial
     */
    private fun animationRotateInitial() {
        //start animation
        animations.rotationView(vb.txtPixelGame,1500L,0)
        //init listener animation
        animations.initListenerAnimation(object :InterfaceListenerAnimation{
            override fun endAnimation() {
                fragmentNavigationManager = FragmentNavigationManager(supportFragmentManager,R.id.fragmentMain,MainSelectFragment(),0)
                //gone txt init
                goneTxtInit()
            }

            override fun startAnimation() {
                Toast.makeText(this@MainActivity, "Start Animation", Toast.LENGTH_SHORT).show()
            }

            override fun repeatAnimation() {
                Toast.makeText(this@MainActivity, "Repeat Animation", Toast.LENGTH_SHORT).show()
            }

        })
    }

    /**
     * Gone txt init
     */
    private fun goneTxtInit() {
        vb.txtPixelGame.visibility = View.GONE
    }
}