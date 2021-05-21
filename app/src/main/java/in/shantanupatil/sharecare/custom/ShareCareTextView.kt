package `in`.shantanupatil.sharecare.custom

import `in`.shantanupatil.sharecare.R
import `in`.shantanupatil.sharecare.constants.NumericalConstants
import `in`.shantanupatil.sharecare.extensions.logInfo
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

private val TAG = ShareCareTextView::class.java.name

/**
 * Custom textView containing custom font.
 */
class ShareCareTextView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defAttrStyled: Int = NumericalConstants.NUMBER_ZERO
) : AppCompatTextView(context, attributeSet, defAttrStyled) {

    init {
        val typedArray: TypedArray =
            context.obtainStyledAttributes(attributeSet, R.styleable.ShareCareTextView, 0, 0)
        try {
            when (typedArray.getInt(R.styleable.ShareCareTextView_customfontStyle, 0)) {
                0 -> typeface = Typeface.createFromAsset(context.assets, "nunito_sans_regular.ttf")
                1 -> typeface = Typeface.createFromAsset(context.assets, "nunito_sans_bold.ttf")
            }
        } catch (e: Exception) {
            context.logInfo(TAG, e.localizedMessage ?: context.getString(R.string.something_went_wrong))
        }
        typedArray.recycle()
    }
}