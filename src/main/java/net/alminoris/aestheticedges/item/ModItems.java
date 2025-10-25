package net.alminoris.aestheticedges.item;

import net.alminoris.aestheticedges.AestheticEdges;
import net.alminoris.aestheticedges.util.helper.BlockSetsHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.Supplier;


public class ModItems
{
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(AestheticEdges.MOD_ID);

    public static final Dictionary<String, DeferredItem<Item>> CURTAINS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.COLORS)
        {
            put(name, registerItem("curtain_"+name, () -> new Item(new Item.Properties().stacksTo(16))));
        }
    }};

    public static final DeferredItem<Item> CURTAIN_REMOVER = registerItem("curtain_remover", () -> new TieredItem(Tiers.STONE, new Item.Properties().stacksTo(1)));

    private static <T extends Item> DeferredItem<T> registerItem(String name, Supplier<T> item)
    {
        return ITEMS.register(name, item);
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}