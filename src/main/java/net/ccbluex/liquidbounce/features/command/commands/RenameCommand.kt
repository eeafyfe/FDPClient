/*
 * FDPClient Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge by LiquidBounce.
 * https://github.com/SkidderMC/FDPClient/
 */
package net.ccbluex.liquidbounce.features.command.commands

import net.ccbluex.liquidbounce.features.command.Command
import net.ccbluex.liquidbounce.utils.misc.StringUtils
import net.ccbluex.liquidbounce.utils.render.ColorUtils

class RenameCommand : Command("rename", emptyArray()) {
    /**
     * Execute commands with provided [args]
     */
    override fun execute(args: Array<String>) {
        if (args.size > 1) {
            val item = mc.thePlayer.heldItem
            if (item == null || item.item == null) {
                chat("§c§lError: §3You need to hold a item.")
                return
            }

            item.setStackDisplayName(ColorUtils.translateAlternateColorCodes(StringUtils.toCompleteString(args, 1)))
            chat("§3Item renamed to '${item.displayName}§3'")
            return
        }

        chatSyntax("rename <name>")
    }
}