package cn.nukkit.level;


import cn.nukkit.level.gamerule.GameRuleMap;
import cn.nukkit.level.gamerule.GameRules;
import cn.nukkit.math.Vector3;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

@ToString
public class LevelData {
    private static final AtomicLongFieldUpdater<LevelData> currentTickUpdater = AtomicLongFieldUpdater.newUpdater(
            LevelData.class, "currentTick");

    private final Map<String, Object> generatorOptions = new HashMap<>();
    private final GameRuleMap gameRules = new GameRuleMap();
    private volatile long currentTick;
    private long seed = ThreadLocalRandom.current().nextLong();
    private int dimension;
    private int generator;
    private String name = "World";
    private int time;
    private Vector3 spawn = new Vector3(0, 128, 0);
    private int serverChunkTickRange;
    private int spawnRadius;
    private int rainTime;
    private int lightningTime;
    private float rainLevel;
    private float lightningLevel;
    private int difficulty;
    private int storageVersion;
    private int gameType;
    private Vector3 limitedWorldOrigin;
    private int netherScale;
    private int networkVersion;
    private int platform;
    private long worldStartCount;
    private long lastPlayed;

    private boolean bonusChestEnabled;
    private boolean bonusChestSpawned;
    private boolean forceGameType;
    private boolean educationFeaturesEnabled;
    private boolean eduLevel;
    private boolean hasBeenLoadedInCreative;
    private boolean hasLockedBehaviorPack;
    private boolean hasLockedResourcePack;
    private boolean immutableWorld;
    private boolean texturePacksRequired;


    public LevelData() {
    }

    public LevelData(LevelData levelData) {
        this.generatorOptions.putAll(levelData.generatorOptions);
        this.gameRules.putAll(levelData.gameRules);
        this.generator = levelData.generator;
        this.name = levelData.name;
        this.spawn = levelData.spawn;
        this.serverChunkTickRange = levelData.serverChunkTickRange;
        this.spawnRadius = levelData.spawnRadius;
        this.rainTime = levelData.rainTime;
        this.lightningTime = levelData.lightningTime;
        this.rainLevel = levelData.rainLevel;
        this.lightningLevel = levelData.lightningLevel;
        this.difficulty = levelData.difficulty;
    }

    public GameRuleMap getGameRules() {
        return this.gameRules;
    }

    public void checkTime(int tickRate) {
        if (this.gameRules.get(GameRules.DO_DAYLIGHT_CYCLE)) {
            this.time += tickRate;
        }
    }

    void tick() {
        currentTickUpdater.incrementAndGet(this);
    }

    public void addTime(int time) {
        this.time += time;
    }

    public Map<String, Object> getGeneratorOptions() {
        return this.generatorOptions;
    }

    public long getCurrentTick() {
        return this.currentTick;
    }

    public void setCurrentTick(long currentTick) {
        this.currentTick = currentTick;
    }

    public long getSeed() {
        return this.seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public int getDimension() {
        return this.dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getGenerator() {
        return this.generator;
    }

    public void setGenerator(int generator) {
        this.generator = generator;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Vector3 getSpawn() {
        return this.spawn;
    }

    public void setSpawn(Vector3 spawn) {
        this.spawn = spawn;
    }

    public int getServerChunkTickRange() {
        return this.serverChunkTickRange;
    }

    public void setServerChunkTickRange(int serverChunkTickRange) {
        this.serverChunkTickRange = serverChunkTickRange;
    }

    public int getSpawnRadius() {
        return this.spawnRadius;
    }

    public void setSpawnRadius(int spawnRadius) {
        this.spawnRadius = spawnRadius;
    }

    public int getRainTime() {
        return this.rainTime;
    }

    public void setRainTime(int rainTime) {
        this.rainTime = rainTime;
    }

    public int getLightningTime() {
        return this.lightningTime;
    }

    public void setLightningTime(int lightningTime) {
        this.lightningTime = lightningTime;
    }

    public float getRainLevel() {
        return this.rainLevel;
    }

    public void setRainLevel(float rainLevel) {
        this.rainLevel = rainLevel;
    }

    public float getLightningLevel() {
        return this.lightningLevel;
    }

    public void setLightningLevel(float lightningLevel) {
        this.lightningLevel = lightningLevel;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getStorageVersion() {
        return this.storageVersion;
    }

    public void setStorageVersion(int storageVersion) {
        this.storageVersion = storageVersion;
    }

    public int getGameType() {
        return this.gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public Vector3 getLimitedWorldOrigin() {
        return this.limitedWorldOrigin;
    }

    public void setLimitedWorldOrigin(Vector3 limitedWorldOrigin) {
        this.limitedWorldOrigin = limitedWorldOrigin;
    }

    public int getNetherScale() {
        return this.netherScale;
    }

    public void setNetherScale(int netherScale) {
        this.netherScale = netherScale;
    }

    public int getNetworkVersion() {
        return this.networkVersion;
    }

    public void setNetworkVersion(int networkVersion) {
        this.networkVersion = networkVersion;
    }

    public int getPlatform() {
        return this.platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public long getWorldStartCount() {
        return this.worldStartCount;
    }

    public void setWorldStartCount(long worldStartCount) {
        this.worldStartCount = worldStartCount;
    }

    public long getLastPlayed() {
        return this.lastPlayed;
    }

    public void setLastPlayed(long lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public boolean isBonusChestEnabled() {
        return this.bonusChestEnabled;
    }

    public void setBonusChestEnabled(boolean bonusChestEnabled) {
        this.bonusChestEnabled = bonusChestEnabled;
    }

    public boolean isBonusChestSpawned() {
        return this.bonusChestSpawned;
    }

    public void setBonusChestSpawned(boolean bonusChestSpawned) {
        this.bonusChestSpawned = bonusChestSpawned;
    }

    public boolean isForceGameType() {
        return this.forceGameType;
    }

    public void setForceGameType(boolean forceGameType) {
        this.forceGameType = forceGameType;
    }

    public boolean isEducationFeaturesEnabled() {
        return this.educationFeaturesEnabled;
    }

    public void setEducationFeaturesEnabled(boolean educationFeaturesEnabled) {
        this.educationFeaturesEnabled = educationFeaturesEnabled;
    }

    public boolean isEduLevel() {
        return this.eduLevel;
    }

    public void setEduLevel(boolean eduLevel) {
        this.eduLevel = eduLevel;
    }

    public boolean isHasBeenLoadedInCreative() {
        return this.hasBeenLoadedInCreative;
    }

    public void setHasBeenLoadedInCreative(boolean hasBeenLoadedInCreative) {
        this.hasBeenLoadedInCreative = hasBeenLoadedInCreative;
    }

    public boolean isHasLockedBehaviorPack() {
        return this.hasLockedBehaviorPack;
    }

    public void setHasLockedBehaviorPack(boolean hasLockedBehaviorPack) {
        this.hasLockedBehaviorPack = hasLockedBehaviorPack;
    }

    public boolean isHasLockedResourcePack() {
        return this.hasLockedResourcePack;
    }

    public void setHasLockedResourcePack(boolean hasLockedResourcePack) {
        this.hasLockedResourcePack = hasLockedResourcePack;
    }

    public boolean isImmutableWorld() {
        return this.immutableWorld;
    }

    public void setImmutableWorld(boolean immutableWorld) {
        this.immutableWorld = immutableWorld;
    }

    public boolean isTexturePacksRequired() {
        return this.texturePacksRequired;
    }

    public void setTexturePacksRequired(boolean texturePacksRequired) {
        this.texturePacksRequired = texturePacksRequired;
    }
}