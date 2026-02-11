/*
 * Copyright (C) 2025 MisterCheezeCake
 *
 * This file is part of Compostable Bamboo.
 *
 * Compostable Bamboo is free software: you can redistribute it
 * and/or modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * Compostable Bamboo is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Compostable Bamboo. If not, see <https://www.gnu.org/licenses/>.
 */
package wtf.cheeze.bamboo.mixin;

import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ComposterBlock.class)
public abstract class ComposterBlockMixin {

    @Shadow
    private static void registerCompostableItem(float levelIncreaseChance, ItemConvertible item) {
		throw new AssertionError();
    }

    @Inject(method = "registerDefaultCompostableItems", at = @At("TAIL"))
    private static void compostableBamboo$registerCompostable(CallbackInfo ci) {
		registerCompostableItem(0.3F, Items.BAMBOO);

	}

}