package `in`.shantanupatil.sharecare.custom

import `in`.shantanupatil.sharecare.R
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

/**
 * Edittext with custom background.
 */
class ShareCareEditText @JvmOverloads constructor(
    context: Context, attributeSet: AttributeSet? = null, defAttrStyle: Int = 0
) : AppCompatEditText(context, attributeSet, defAttrStyle) {

    init {
        setBackgroundResource(R.drawable.edittext_background)
    }
}