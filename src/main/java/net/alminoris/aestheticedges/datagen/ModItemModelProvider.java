package net.alminoris.aestheticedges.datagen;

import net.alminoris.aestheticedges.AestheticEdges;
import net.alminoris.aestheticedges.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;


import static net.alminoris.aestheticedges.util.helper.BlockSetsHelper.COLORS;

public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, AestheticEdges.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        for (String name : COLORS)
        {
            generatedItem(ModItems.CURTAINS.get(name));
        }
        generatedItem(ModItems.CURTAIN_REMOVER);
    }

    private ItemModelBuilder generatedItem(DeferredItem<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AestheticEdges.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AestheticEdges.MOD_ID,"item/" + item.getId().getPath()));
    }
}