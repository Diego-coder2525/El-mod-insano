package com.diego.modone.item;

import com.diego.modone.modone;
import com.diego.modone.util.Config;
import com.diego.modone.util.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class CopperedApple extends Item {
    public CopperedApple()
    {
        super(new Properties().group(modone.COURSE_TAB)
                .food(new Food.Builder()
                        .hunger(5)
                        .saturation(1.5f)
                        .effect(()->new EffectInstance(Effects.GLOWING, Config.COPPERED_GLOW_DUR.get(),1),0.5f).build()));

    }
    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag){
        if(KeyboardHelper.isHoldingShift())
        {
            tooltip.add(new StringTextComponent("Turns sheep into Copper Ingots"));
        }
        else
        {
            tooltip.add(new StringTextComponent("Hold"+"\u00A7d"+" SHIFT"+"\u00A77"+" for more information"));
        }
        super.addInformation(stack, world, tooltip, flag);
    }
}
