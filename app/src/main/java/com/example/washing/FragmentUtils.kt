package com.example.washing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
object FragmentUtils {

    @JvmOverloads
    fun replaceFragment(fm: FragmentManager?, fragment: Fragment, layoutId: Int, isAnimate: Boolean = false,
                        isAddBackStack: Boolean = true, tag: String? = null, forceCommit: Boolean = false) {
        if(fm == null) return
        val transaction = fm.beginTransaction()

        if (isAnimate) {
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right)
        }

        if (tag.isNullOrEmpty()) {
            transaction.replace(layoutId, fragment)
        } else {
            transaction.replace(layoutId, fragment, tag)
        }


        if (isAddBackStack) {
            transaction.addToBackStack(fragment.javaClass.simpleName)
        }

        try {
            if(!forceCommit){
                transaction.commitAllowingStateLoss()
            }else{
                transaction.commit()
            }

        }catch (ex: Exception){

        }

    }

    @JvmOverloads
    fun addFragment(fm: FragmentManager?, fragment: Fragment, layoutId: Int, isAnimate: Boolean = false,
                    isAddBackStack: Boolean = true, tag: String? = null, forceCommit: Boolean = false) {

        if (fm == null) return
        val transaction = fm.beginTransaction()

        if (isAnimate) {
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right)
        }

        if (tag.isNullOrEmpty()) {
            transaction.add(layoutId, fragment)
        } else {
            transaction.add(layoutId, fragment, tag)
        }

        if (isAddBackStack) {
            transaction.addToBackStack(fragment.javaClass.simpleName)
        }

        try {
            if(!forceCommit){
                transaction.commitAllowingStateLoss()
            }else{
                transaction.commit()
            }

        }catch (ex: Exception){

        }
    }
}
