package wict.wictphiladelphia.org.wict.utils

import android.content.Context
import android.graphics.Typeface

class WictFontProvider{

    companion object {
        val BrandonBold = 1
        val BrandonBoldItalics=2
        val BrandonBlack=3
        val BrandonBlackItalics=4
        val BrandonLight=5
        val BrandonLightItalics=6
        val BrandonMedium=7
        val BrandonMediumItalics=8
        val BrandonRegular=9
        val BrandonRegularItalics=10
        val BrandonThin=11
        val BrandonThinItalics=12


        var typeFaceBold:Typeface?=null
        var typeFaceBoldItalics:Typeface?=null
        var typeFaceBlack:Typeface?=null
        var typeFaceBlackItalics:Typeface?=null
        var typeFaceLight:Typeface?=null
        var typeFaceLightItalics:Typeface?=null


        var typeFaceMedium:Typeface?=null
        var typeFaceMediumItalics:Typeface?=null

        var typeFaceRegular:Typeface?=null
        var typeFaceRegularItalics:Typeface?=null

        var typeFaceThin:Typeface?=null
        var typeFaceThinItalics:Typeface?=null


        fun getFont(context: Context, type:Int): Typeface?{

            when(type){
                BrandonBold ->{
                    if (typeFaceBold == null){
                        typeFaceBold = Typeface.createFromAsset(context.applicationContext.assets, "fonts/Brandon_bld.otf")

                    }
                    return typeFaceBold!!
                }
                BrandonBoldItalics ->{
                    if (typeFaceBoldItalics == null){
                        typeFaceBoldItalics = Typeface.createFromAsset(context.applicationContext.assets, "fonts/Brandon_bld_it.otf")
                    }
                    return typeFaceBoldItalics!!

                }
                BrandonBlack ->{
                    if (typeFaceBlack == null){
                        typeFaceBlack = Typeface.createFromAsset(context.applicationContext.assets, "fonts/Brandon_blk.otf")
                    }
                    return typeFaceBlack!!

                }
                BrandonBlackItalics ->{
                    if (typeFaceBlackItalics == null){
                        typeFaceBlackItalics = Typeface.createFromAsset(context.applicationContext.assets, "fonts/Brandon_blk_it.otf")

                    }
                    return typeFaceBlackItalics!!

                }
                BrandonLight ->{
                    if (typeFaceLight == null){
                        typeFaceLight = Typeface.createFromAsset(context.applicationContext.assets, "fonts/Brandon_light.otf")
                    }
                    return typeFaceLight!!

                }
                BrandonLightItalics ->{
                    if (typeFaceLightItalics == null){
                        typeFaceLightItalics = Typeface.createFromAsset(context.applicationContext.assets, "fonts/Brandon_light_it.otf")

                    }
                    return typeFaceLightItalics!!

                }
                BrandonMedium ->{
                    if (typeFaceMedium == null){
                        typeFaceMedium = Typeface.createFromAsset(context.applicationContext.assets, "fonts/Brandon_med.otf")
                    }
                    return typeFaceMedium!!

                }

                BrandonMediumItalics ->{
                    if (typeFaceMediumItalics == null){
                        typeFaceMediumItalics = Typeface.createFromAsset(context.applicationContext.assets, "fonts/Brandon_med_it.otf")
                    }
                    return typeFaceMediumItalics!!

                }
                BrandonRegular ->{
                    if (typeFaceRegular == null){
                        typeFaceRegular = Typeface.createFromAsset(context.applicationContext.assets, "fonts/Brandon_reg.otf")

                    }
                    return typeFaceRegular!!

                }
                BrandonRegularItalics ->{
                    if (typeFaceRegularItalics == null){
                        typeFaceRegularItalics = Typeface.createFromAsset(context.applicationContext.assets, "fonts/Brandon_reg_it.otf")
                    }
                    return typeFaceRegularItalics!!

                }
                BrandonThin ->{
                    if (typeFaceThin == null){
                        typeFaceThin = Typeface.createFromAsset(context.applicationContext.assets, "fonts/Brandon_thin.otf")
                    }
                    return typeFaceThin!!

                }
                BrandonThinItalics ->{
                    if (typeFaceThinItalics == null){
                        typeFaceThinItalics = Typeface.createFromAsset(context.applicationContext.assets, "fonts/Brandon_thin_it.otf")
                    }
                    return typeFaceThinItalics!!

                }


            }
            return null

        }


    }

}