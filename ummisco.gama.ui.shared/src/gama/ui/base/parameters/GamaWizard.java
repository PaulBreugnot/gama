package gama.ui.base.parameters;

import java.util.List;

import org.eclipse.jface.wizard.Wizard;

import gama.runtime.GAMA;
import gama.util.GamaMapFactory;
import gama.util.IMap;
import gaml.descriptions.ActionDescription;
import gaml.descriptions.ConstantExpressionDescription;
import gaml.expressions.IExpression;
import gaml.statements.ActionStatement;
import gaml.statements.Arguments;


public class GamaWizard extends Wizard{
	protected List<GamaWizardPage> pages;
	protected String title;
	protected IExpression exp;
	protected ActionDescription finish;
	
	public GamaWizard(String title, ActionDescription finish, List<GamaWizardPage> pages) {
        super();
        this.title = title;
        this.pages = pages;
        setNeedsProgressMonitor(true);
       	this.finish = finish;
    }

    @Override
    public String getWindowTitle() {
        return title;
    }
    
    public IMap<String,IMap<String, Object>> getValues() {
    	IMap<String,IMap<String, Object>> values = GamaMapFactory.create();
    	for(GamaWizardPage p : pages) {
    		values.put(p.getTitle(),p.getValues());
    	}
    	return values;
    }

    @Override
    public void addPages() {
    	for (GamaWizardPage p : pages) {
    		  addPage(p);
    	}
    }

    @Override
    public boolean canFinish() {
    	if (finish == null) return true;
    	ActionStatement actionSC = (ActionStatement) finish.compile();
    	if(finish.getArgNames().isEmpty()) return  (Boolean) actionSC.executeOn(GAMA.getRuntimeScope());
        final Arguments argsSC = new Arguments();
    	argsSC.put(finish.getArgNames().get(0), ConstantExpressionDescription.create(getValues()));
		actionSC.setRuntimeArgs(GAMA.getRuntimeScope(), argsSC);
		final Boolean isFinished = (Boolean) actionSC.executeOn(GAMA.getRuntimeScope());
		return isFinished;
    }

	@Override
	public boolean performFinish() {
		return true;
	}
    
   

}
