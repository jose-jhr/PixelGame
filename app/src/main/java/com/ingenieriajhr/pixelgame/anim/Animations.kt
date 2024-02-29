package com.ingenieriajhr.pixelgame.anim

import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation

interface InterfaceListenerAnimation{
    //end Animation Rotate
    fun endAnimation()
    //start Animation
    fun startAnimation()
    //repeat Animation
    fun repeatAnimation()
}


class Animations(val context: Context) {

    //private endAnimationRotate
    private lateinit var listenerAnimation: InterfaceListenerAnimation

    //init Listener Rotate
    fun initListenerAnimation(endAnimationRotate: InterfaceListenerAnimation){
        this.listenerAnimation = endAnimationRotate
    }


    fun rotationView(mView:View,timeDurationAnim:Long,numberRepetition:Int){
        val rotateAnimation =  RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,
            0.5F,Animation.RELATIVE_TO_SELF,0.5f)
        //listener
        rotateAnimation.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                listenerAnimation.startAnimation()
            }

            override fun onAnimationEnd(p0: Animation?) {
                listenerAnimation.endAnimation()
            }

            override fun onAnimationRepeat(p0: Animation?) {
                listenerAnimation.repeatAnimation()
            }

        })

        //interpolator
        rotateAnimation.interpolator = LinearInterpolator()
        //repeat
        rotateAnimation.repeatCount = numberRepetition
        //duration animation
        rotateAnimation.duration = timeDurationAnim
        //set Animation ROTATION to mView
        mView.startAnimation(rotateAnimation)

    }


    fun scaleAnimation(mView: View,timeDuration:Long,numberRepetition:Int,scaleAnimation: ScaleAnimation){
        //scale animation
        val scaleAnimation = scaleAnimation
        scaleAnimation.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                listenerAnimation.startAnimation()
            }

            override fun onAnimationEnd(p0: Animation?) {
                listenerAnimation.endAnimation()
            }

            override fun onAnimationRepeat(p0: Animation?) {
                listenerAnimation.repeatAnimation()
            }

        })
        //time duration
        scaleAnimation.duration = timeDuration
        //repeat
        scaleAnimation.repeatCount = numberRepetition
        //start scaleAnimation
        scaleAnimation.start()




    }


}