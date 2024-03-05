package com.ingenieriajhr.pixelgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.ingenieriajhr.pixelgame.anim.Animations
import com.ingenieriajhr.pixelgame.anim.InterfaceListenerAnimation
import com.ingenieriajhr.pixelgame.databinding.ActivityMainBinding
import com.ingenieriiajhr.jhrCameraX.CameraJhr

class MainActivity : AppCompatActivity() {

    lateinit var vb:ActivityMainBinding

    //Animation Rotate
    lateinit var animations:Animations

    //Init cameraXJHR
    lateinit var cameraJhr: CameraJhr
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

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (cameraJhr.allpermissionsGranted()&&!cameraJhr.ifStartCamera){
            starCameraJhr()
        }else{
            cameraJhr.noPermissions()
        }
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
                Toast.makeText(this@MainActivity, "End animation", Toast.LENGTH_SHORT).show()
            }

            override fun startAnimation() {
                Toast.makeText(this@MainActivity, "Start Animation", Toast.LENGTH_SHORT).show()
            }

            override fun repeatAnimation() {
                Toast.makeText(this@MainActivity, "Repeat Animation", Toast.LENGTH_SHORT).show()
            }

        })
    }
}