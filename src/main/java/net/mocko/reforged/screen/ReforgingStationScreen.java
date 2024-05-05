package net.mocko.reforged.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.mocko.reforged.Reforged;
import net.mocko.reforged.networking.ModMessages;
import net.mocko.reforged.networking.packet.ExampleC2SPacket;
import net.mocko.reforged.reforging.ReforgingFollower;
import net.mocko.reforged.reforging.ReforgingGrid;
import net.mocko.reforged.reforging.ReforgingPatterns;
import net.mocko.reforged.reforging.ReforgingTile;

import java.awt.*;

public class ReforgingStationScreen extends AbstractContainerScreen<ReforgingStationMenu> {

    private static final ResourceLocation REFORGING_STATION_GUI= new ResourceLocation(Reforged.MOD_ID, "textures/gui/reforging_station_gui.png");


    private ReforgingGrid grid;
    private ReforgingFollower follower;
    private ImageButton button;

    private int x;
    private int y;

    private int reforgingAreaTop;
    private int reforgingAreaLeft;
    private boolean isScrolling;

    private int activeButton = -1;

    @Override
    protected void init(){

        grid = new ReforgingGrid();
        follower = new ReforgingFollower();

        super.init();
        this.imageHeight = 222;
        reforgingAreaTop = this.topPos + 9;
        reforgingAreaLeft= this.leftPos + 8;

        this.button = addRenderableWidget(new ImageButton
                (this.leftPos + 141, this.topPos + 114, 20, 20, 177, 0, 20,
                        REFORGING_STATION_GUI,
                        (button) -> {
                            follower.addPatternCordinates(this.menu.getPattern());
                            this.menu.consumeItems();
                            //CONSUME ITEM ON THE FIRST SLOT
                }
                ));
    }

    public ReforgingStationScreen(ReforgingStationMenu p_97741_, Inventory p_97742_, Component p_97743_) {
        super(p_97741_, p_97742_, p_97743_);
    }

    @Override
    protected void renderBg( PoseStack guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, REFORGING_STATION_GUI);



        this.blit(guiGraphics,this.leftPos, this.topPos, 0, 0, imageWidth, imageHeight);
        for(int j = 0; j < grid.gridHeight; j++)
        {
            for(int i = 0; i < grid.gridWidth; i++){
                fill(guiGraphics,
                        this.reforgingAreaLeft + i*ReforgingTile.tileSize,
                        this.reforgingAreaTop + j*ReforgingTile.tileSize,
                        this.reforgingAreaLeft + ReforgingTile.tileSize + i*ReforgingTile.tileSize,
                        this.reforgingAreaTop + ReforgingTile.tileSize + j*ReforgingTile.tileSize,
                        grid.getTileColor(i,j));
            }
        }

        fill(guiGraphics,
                this.reforgingAreaLeft + follower.followerX,
                this.reforgingAreaTop + follower.followerY,
                this.reforgingAreaLeft + follower.followerX + ReforgingTile.tileSize,
                this.reforgingAreaTop + follower.followerY + + ReforgingTile.tileSize,
                0XFFFFFFFF
                );
    }

    @Override
    public void render( PoseStack pPoseStack, int mouseX, int mouseY, float delta )
    {
        renderBackground(pPoseStack);
        super.render(pPoseStack,mouseX,mouseY,delta);
        renderTooltip(pPoseStack,mouseX,mouseY);

    }

    /*
    @Override
    public boolean mouseDragged(double d0, double d1, int activeButton, double d2, double d3){
        if (activeButton != 0) {
            this.isScrolling = false;
            return false;
        }
        else {
            if (!this.isScrolling)
            {
                this.isScrolling = true;
            }
                this.x = (int)d2;
                this.y = (int)d3;
            return true;
        }
    }
     */

    @Override
    protected void renderLabels(PoseStack p_97808_, int p_97809_, int p_97810_) {
       // this.font.draw(p_97808_, this.title, (float)this.titleLabelX, (float)this.titleLabelY, 4210752);
       // this.font.draw(p_97808_, this.playerInventoryTitle, (float)this.inventoryLabelX, (float)this.inventoryLabelY, 4210752);
    }



}
