package twilightforest.world.layer;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;
import twilightforest.biomes.TFBiomes;

import java.util.List;
import java.util.function.Supplier;

/**
 * Applies the twilight forest biomes to the map
 *
 * @author Ben
 */
public class GenLayerTFBiomes implements IAreaTransformer0 {
	private static final int RARE_BIOME_CHANCE = 15;

	protected static final List<Supplier<Biome>> commonBiomes = ImmutableList.of(
			//TFBiomes.twilightForest, FIXME Nothing generates
			//TFBiomes.denseTwilightForest,
			//TFBiomes.mushrooms,
			//TFBiomes.oakSavanna,
			//TFBiomes.fireflyForest
	);
	protected static final List<Supplier<Biome>> rareBiomes = ImmutableList.of(
			//TFBiomes.tfLake,
			//TFBiomes.deepMushrooms,
			//TFBiomes.enchantedForest,
			//TFBiomes.clearing,
			//TFBiomes.spookyForest
	);


	public GenLayerTFBiomes() { }

	@Override
	public int apply(INoiseRandom iNoiseRandom, int x, int y) {
		return 0; //getRandomBiome(iNoiseRandom, commonBiomes));

		/*if (iNoiseRandom.random(RARE_BIOME_CHANCE) == 0) {
			// make rare biome
			return Registry.BIOME.getId(getRandomBiome(iNoiseRandom, rareBiomes));
		} else {
			// make common biome
			return Registry.BIOME.getId(getRandomBiome(iNoiseRandom, commonBiomes));
		}*/
	}

	private Biome getRandomBiome(INoiseRandom random, List<Supplier<Biome>> biomes) {
		return biomes.get(random.random(biomes.size())).get();
	}
}
