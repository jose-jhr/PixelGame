package com.ingenieriajhr.pixelgame.handler

import android.content.Context
import android.graphics.Bitmap
import androidx.camera.core.ImageProxy
import androidx.camera.view.PreviewView
import com.ingenieriiajhr.jhrCameraX.BitmapResponse
import com.ingenieriiajhr.jhrCameraX.CameraJhr
import com.ingenieriiajhr.jhrCameraX.ImageProxyResponse


//Interface retur Bitmap
interface ReturnBitmap{
    fun dataBitmap(bitmap: Bitmap)
}


class CameraPixelHandler(val mContext:Context,val cameraPreview: PreviewView,val imageProxy:Boolean,val imageBitmap: Boolean) {

    //return bitmap interface
    lateinit var bitmapListener: ReturnBitmap

    fun setBitmapInterface(returnBitmap: ReturnBitmap){
        this.bitmapListener = returnBitmap
    }

    //init camera Jhr
    var cameraJhr: CameraJhr = CameraJhr(mContext)

    fun startCamera(){
        cameraJhr.addlistenerBitmap(object : BitmapResponse {
            override fun bitmapReturn(bitmap: Bitmap?) {
                if (bitmap!=null){
                    bitmapListener.dataBitmap(bitmap)
                }
            }
        })

        cameraJhr.addlistenerImageProxy(object : ImageProxyResponse {
            override fun imageProxyReturn(imageProxy: ImageProxy) {
                try {
                    /*val bitmap = Bitmap.createBitmap(imageProxy.width,imageProxy.height,Bitmap.Config.ARGB_8888)
                    imageProxy.use { bitmap.copyPixelsFromBuffer(imageProxy.planes[0].buffer) }
                    runOnUiThread {
                        binding.imgBitMap.setImageBitmap(bitmap)
                    }*/
                }catch (e: IllegalStateException) {
                    // Handle the exception here
                    println("error en conversion imageproxy")
                }

            }
        })

        cameraJhr.initBitmap()
        cameraJhr.initImageProxy()
        //selector camera LENS_FACING_FRONT = 0;    LENS_FACING_BACK = 1;
        //aspect Ratio  RATIO_4_3 = 0; RATIO_16_9 = 1;  false returImageProxy, true return bitmap
        if (imageBitmap){
            cameraJhr.start(0,0,cameraPreview,false,false,true)
        }else{
            cameraJhr.start(0,0,cameraPreview,false,true,false)

        }
    }
}
