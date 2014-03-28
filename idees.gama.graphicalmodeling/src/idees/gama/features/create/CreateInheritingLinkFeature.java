package idees.gama.features.create;


import gama.EContinuousTopology;
import gama.EInheritLink;
import gama.ESpecies;
import gama.EWorldAgent;
import idees.gama.features.ExampleUtil;
import idees.gama.features.add.AddSpeciesFeature;
import idees.gama.features.modelgeneration.ModelGenerator;
import idees.gama.ui.image.GamaImageProvider;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class CreateInheritingLinkFeature extends AbstractCreateSpeciesComponentLinkFeature {

	 private static final String TITLE = "Create child species";
	  
	 private static final String USER_QUESTION = "Enter new species name";
	 
	
	public CreateInheritingLinkFeature(IFeatureProvider fp) {
		// provide name and description for the UI, e.g. the palette
		super(fp, "is parent species of a species", "Create a new specialized species");
	}

	private ESpecies createESpecies(ICreateConnectionContext context) {
		String newSpeciesName = ExampleUtil.askString(TITLE, USER_QUESTION, "my_species");
	    if (newSpeciesName == null || newSpeciesName.trim().length() == 0) {
	    	return null;
	    }  
	    ESpecies newSpecies = gama.GamaFactory.eINSTANCE.createESpecies();
	    newSpecies.setError("");
	    newSpecies.setHasError(false);
		
		this.getDiagram().eResource().getContents().add(newSpecies);
		newSpecies.setName(newSpeciesName);
		CreateContext ac = new CreateContext();
		EContinuousTopology newTopo = gama.GamaFactory.eINSTANCE.createEContinuousTopology();
		this.getDiagram().eResource().getContents().add(newTopo);
		newSpecies.setTopology(newTopo);
		ac.setLocation(context.getTargetLocation().getX(), context.getTargetLocation().getY());
		ac.setSize(0, 0);
		ac.setTargetContainer(getDiagram());
		ModelGenerator.modelValidation(getFeatureProvider(), getDiagram());
		return newSpecies;
	}
	
	private PictogramElement addESpecies(ICreateConnectionContext context, ESpecies species) {
		CreateContext cc = new CreateContext();
		cc.setLocation(context.getTargetLocation().getX() - (int)(AddSpeciesFeature.INIT_WIDTH/2.0), context.getTargetLocation().getY() - (int)(AddSpeciesFeature.INIT_HEIGHT/2.0));
		cc.setSize(0, 0);
		cc.setTargetContainer(getDiagram());
		return getFeatureProvider().addIfPossible(new AddContext(cc, species));
	}
	
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;
		ESpecies source = getESpecies(context.getSourceAnchor());
		ESpecies target = createESpecies(context);
		if (source != null && target != null) {
			PictogramElement targetpe = addESpecies(context, target);
			// create new business object
			EInheritLink eReference = createEReference(source, target);
			//eReference.setModel(source.getModel());
			getDiagram().eResource().getContents().add(eReference);
			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), getAnchor(targetpe));
			addContext.setNewObject(eReference);
			newConnection = (Connection) getFeatureProvider().addIfPossible(
					addContext);
			eReference.setParent(source);
			eReference.setChild(target);
			target.setInheritsFrom(source);
			source.getInheritingLinks().add(eReference);
		}

		return newConnection;
	}


	/**
	 * Creates a EReference between two EClasses.
	 */
	private EInheritLink createEReference(ESpecies source, ESpecies target) {
		EInheritLink eReference = gama.GamaFactory.eINSTANCE.createEInheritLink();
		return eReference;
	}

	
	@Override
	public String getCreateImageId() {
		return GamaImageProvider.IMG_INHERITINGLINK;
	}
	
	protected ESpecies getESpecies(Anchor anchor) {
		if (anchor != null) {
			Object object = getBusinessObjectForPictogramElement(anchor
					.getParent());
			if (object instanceof ESpecies && !(object instanceof EWorldAgent) && ((ESpecies)object).getTopology() instanceof EContinuousTopology) {
				return (ESpecies) object;
			}
		}
		return null;
	}
	

}
