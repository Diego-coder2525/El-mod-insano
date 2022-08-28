package com.diego.modone.events;

import com.diego.modone.item.ModItems;
import com.diego.modone.util.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;

import java.util.Collection;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class ModEvents {
    @SubscribeEvent
    public void onCopperedSheep(AttackEntityEvent event){
        if(event.getPlayer().getHeldItemMainhand().getItem()== ModItems.COPPERED_APPLE.get()){
            if(event.getTarget().isAlive()){
                LivingEntity target = (LivingEntity) event.getTarget();
                if(target instanceof SheepEntity){
                    PlayerEntity player = event.getPlayer();

                    // delete "one" held item
                    player.getHeldItemMainhand().shrink(1);

                    target.addPotionEffect(new EffectInstance(Effects.GLOWING, Config.COPPERED_GLOW_DUR.get()));
                    if(!player.world.isRemote())
                    {
                        String msg = TextFormatting.YELLOW + "Oveja ta glowing";
                        player.sendMessage(new StringTextComponent(msg),player.getUniqueID());


                    }
                }
            }
        }

    }

    @SubscribeEvent
    public void onRigthClickCopperSword(PlayerInteractEvent.RightClickItem event){
        int time=200;
        if(event.getPlayer().getHeldItemMainhand().getItem() == ModItems.COPPER_SWORD.get()){
            PlayerEntity player=event.getPlayer();

            if(!player.isPotionActive(Effects.STRENGTH)){

                event.getPlayer().getHeldItemMainhand().damageItem(20, event.getPlayer(), new Consumer<PlayerEntity>() {
                    @Override
                    public void accept(PlayerEntity playerEntity) {

                    }
                });
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH,time,2));

        }
        }

    }
    @SubscribeEvent
    public void onCopperedSheepDrop(LivingDropsEvent event)
    {

        LivingEntity entity = event.getEntityLiving();
        if(entity instanceof SheepEntity){
            World world = entity.getEntityWorld();
            Collection<ItemEntity> drops = event.getDrops();

            //LogManager.getLogger().debug(entity.getActivePotionEffect());

            if(entity.isPotionActive(Effects.GLOWING))
            {

                drops.add(new ItemEntity(world,entity.getPosX(),entity.getPosY(),entity.getPosZ(),new ItemStack(ModItems.COPPER_INGOT.get())));

            }

        }
    }
    @SubscribeEvent
    public void evento(AttackEntityEvent event){

    }
}
