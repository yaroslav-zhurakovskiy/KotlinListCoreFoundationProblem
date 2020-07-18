import kotlinx.cinterop.CValue
import kotlinx.cinterop.cValue
import platform.UIKit.*
import platform.CoreGraphics.*
import platform.Foundation.NSArray
import platform.Foundation.arrayWithObjects
import platform.QuartzCore.CAGradientLayer
import platform.QuartzCore.CALayer

class GradientView(frame: CValue<CGRect>): UIView(frame = frame) {
    private val gradientLayer = CAGradientLayer()

    init {
        gradientLayer.frame = bounds
        layer.addSublayer(gradientLayer)
    }

    fun setColors(colors: List<UIColor>) {
        gradientLayer.colors = colors.map { it.CGColor }
    }

    fun setColorsDirectlyWithNSArray() {
        gradientLayer.setColors(NSArray.arrayWithObjects(UIColor.redColor.CGColor, UIColor.yellowColor.CGColor))
    }

    fun setColorsDirectlyWithList() {
        gradientLayer.setColors(listOf(UIColor.redColor.CGColor, UIColor.yellowColor.CGColor))
    }

    override fun layoutSublayersOfLayer(layer: CALayer) {
        gradientLayer.frame = bounds
    }
}

fun buildWithDirectColorsWithNSArray(): UIView {
    return GradientView(frame = cValue { CGRectZero } ).apply {
        setColorsDirectlyWithNSArray()
    }
}

fun buildWithDirectColorsWithList(): UIView {
    return GradientView(frame = cValue { CGRectZero } ).apply {
        setColorsDirectlyWithList()
    }
}

fun buildWithColors(colors: List<UIColor>): UIView {
    return GradientView(frame = cValue { CGRectZero } ).apply {
        setColors(colors)
    }
}

