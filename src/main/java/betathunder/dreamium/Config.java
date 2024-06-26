package betathunder.dreamium;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = Dreamium.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    //private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
    //        .comment("Whether to log the dirt block on common setup")
    //        .define("logDirtBlock", true);

    private static final ForgeConfigSpec.IntValue BLOCK_ENTITY_DISTANCE = BUILDER
            .comment("The maximum distance, in blocks, at which to draw TileEntities")
            .defineInRange("blockEntityDistance", 6, 0, 1000000);
    
    private static final ForgeConfigSpec.IntValue BLOCK_INDICATOR_DISTANCE = BUILDER
            .comment("The maximum distance, in blocks, at which to draw a glass block as a placeholder for TileEntities")
            .defineInRange("blockIndicatorDistance", 32, 0, 1000000);
    
    private static final ForgeConfigSpec.IntValue ENTITY_DISTANCE = BUILDER
            .comment("The maximum distance, in blocks, at which to draw Entities")
            .defineInRange("entityDistance", 32, 0, 1000000);

    //public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
    //        .comment("What you want the introduction message to be for the magic number")
    //        .define("magicNumberIntroduction", "The magic number is... ");

    // a list of strings that are treated as resource locations for items
    //private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
    //        .comment("A list of items to log on common setup.")
    //        .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int blockEntityDistance;
    public static int blockIndicatorDistance;
    public static int entityDistance;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
    	blockEntityDistance = BLOCK_ENTITY_DISTANCE.get() * BLOCK_ENTITY_DISTANCE.get();
    	blockIndicatorDistance = BLOCK_INDICATOR_DISTANCE.get() * BLOCK_INDICATOR_DISTANCE.get();
    	entityDistance = ENTITY_DISTANCE.get() * ENTITY_DISTANCE.get();
    }
}
