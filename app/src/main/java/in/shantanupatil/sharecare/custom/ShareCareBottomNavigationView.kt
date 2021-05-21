package `in`.shantanupatil.sharecare.custom

import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.constants.NumericalConstants
import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode

/**
 * A custom bottom navigation view with custom icons size and colors. This is also useful to disable
 * the shifting mode present.
 */
class ShareCareBottomNavigationView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defAttrStyled: Int = NumericalConstants.NUMBER_ZERO
) : BottomNavigationView(context, attributeSet, defAttrStyled) {

    init {

        // Setting the background color
        setBackgroundColor(ContextCompat.getColor(context, R.color.white))

        val typedArray = context.obtainStyledAttributes(
            attributeSet,
            R.styleable.ShareCareBottomNavigationView,
            NumericalConstants.NUMBER_ZERO,
            NumericalConstants.NUMBER_ZERO
        )

        // Setting the icon size of bottom navigation view
        itemIconSize = typedArray.getDimension(
            R.styleable.ShareCareBottomNavigationView_customIconSize,
            context.resources.getDimensionPixelSize(R.dimen.dimen_18).toFloat()
        ).toInt()

        // This disables the shifting mode and makes all label visible at a time, in case of more
        // than 3 items
        labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED

        // Color states of the selected and unselected items
        val colorStates = ColorStateList(
            arrayOf(
                intArrayOf(-android.R.attr.state_checked),
                intArrayOf(android.R.attr.state_checked)
            ),
            intArrayOf(
                ContextCompat.getColor(context, R.color.grey),
                ContextCompat.getColor(context, R.color.colorPrimary)
            )
        )
        itemIconTintList = colorStates
        itemTextColor = colorStates

        typedArray.recycle()

    }
}