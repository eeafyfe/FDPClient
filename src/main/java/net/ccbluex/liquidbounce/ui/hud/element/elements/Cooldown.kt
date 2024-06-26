/*
 * FDPClient Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge by LiquidBounce.
 * https://github.com/SkidderMC/FDPClient/
 */
package net.ccbluex.liquidbounce.ui.hud.element.elements

import net.ccbluex.liquidbounce.ui.hud.element.Border
import net.ccbluex.liquidbounce.ui.hud.element.Element
import net.ccbluex.liquidbounce.ui.hud.element.ElementInfo
import net.ccbluex.liquidbounce.ui.hud.element.Side
import net.ccbluex.liquidbounce.utils.CooldownHelper
import net.ccbluex.liquidbounce.utils.render.RenderUtils
import java.awt.Color

/**
 * CustomHUD cooldown element
 *
 * Shows simulated attack cooldown
 */
@ElementInfo(name = "Cooldown")
class Cooldown(x: Double = 0.0, y: Double = -14.0, scale: Float = 1F,
               side: Side = Side(Side.Horizontal.MIDDLE, Side.Vertical.MIDDLE)) : Element(x, y, scale, side) {

    /**
     * Draw element
     */
    override fun drawElement(partialTicks: Float): Border {
        val progress = CooldownHelper.getAttackCooldownProgress()

        if (progress < 1.0) {
            RenderUtils.drawRect(-25f, 0f, 25.0f, 3f, Color(0, 0, 0, 150).rgb)
            RenderUtils.drawRect(-25f, 0f, 25.0f - 50.0f * progress.toFloat(), 3f, Color(0, 111, 255, 200).rgb)
        }

        return Border(-25F, 0F, 25F, 3F)
    }
}
