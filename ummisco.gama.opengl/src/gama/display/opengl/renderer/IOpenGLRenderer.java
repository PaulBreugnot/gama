package gama.display.opengl.renderer;

import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.swt.GLCanvas;

import gama.common.ui.IGraphics;
import gama.display.opengl.OpenGL;
import gama.display.opengl.renderer.helpers.CameraHelper;
import gama.display.opengl.renderer.helpers.KeystoneHelper;
import gama.display.opengl.renderer.helpers.LightHelper;
import gama.display.opengl.renderer.helpers.PickingHelper;
import gama.display.opengl.renderer.helpers.SceneHelper;
import gama.display.opengl.view.SWTOpenGLDisplaySurface;
import gama.metamodel.shape.GamaPoint;
import gama.outputs.LayeredDisplayData;

public interface IOpenGLRenderer extends GLEventListener, IGraphics.ThreeD {

	void setCanvas(GLCanvas canvas);

	GLCanvas getCanvas();

	void initScene();

	double getWidth();

	double getHeight();

	GamaPoint getRealWorldPointFromWindowPoint(final GamaPoint mouse);

	@Override
	SWTOpenGLDisplaySurface getSurface();

	CameraHelper getCameraHelper();

	KeystoneHelper getKeystoneHelper();

	PickingHelper getPickingHelper();

	OpenGL getOpenGLHelper();

	LightHelper getLightHelper();

	SceneHelper getSceneHelper();

	default LayeredDisplayData getData() {
		return getSurface().getData();
	}

	int getLayerWidth();

	int getLayerHeight();

	default boolean useShader() {
		return false;
	}

	boolean isDisposed();

}