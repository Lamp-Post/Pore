/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blue.lapis.pore.impl.entity;

import blue.lapis.pore.converter.type.material.ItemStackConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.spongepowered.api.data.manipulator.RepresentedItemData;
import org.spongepowered.api.entity.projectile.ThrownPotion;

import java.util.Collection;

public class PoreThrownPotion extends PoreProjectile implements org.bukkit.entity.ThrownPotion {

    public static PoreThrownPotion of(ThrownPotion handle) {
        return WrapperConverter.of(PoreThrownPotion.class, handle);
    }

    protected PoreThrownPotion(ThrownPotion handle) {
        super(handle);
    }

    @Override
    public ThrownPotion getHandle() {
        return (ThrownPotion) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.SPLASH_POTION;
    }

    @Override
    public Collection<PotionEffect> getEffects() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public ItemStack getItem() {
        return ItemStackConverter.of(get(RepresentedItemData.class).getValue());
    }

    @Override
    public void setItem(ItemStack item) {
        RepresentedItemData potion = getOrCreate(RepresentedItemData.class);
        potion.setValue(ItemStackConverter.of(item));
        set(potion);
    }
}
