package gama.ext.serialize.gamaType.converters;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import gama.core.dev.utils.DEBUG;
import gama.ext.bdi.BDIPlan;

public class GamaBDIPlanConverter implements Converter {
	ConverterScope convertScope;

	public GamaBDIPlanConverter(final ConverterScope s) {
		convertScope = s;
	}

	@Override
	public boolean canConvert(final Class arg0) {
		return BDIPlan.class.isAssignableFrom(arg0);
	}

	@Override
	public void marshal(final Object arg0, final HierarchicalStreamWriter arg1, final MarshallingContext arg2) {
		final BDIPlan plan = (BDIPlan) arg0;

		DEBUG.OUT("ConvertAnother : BDIPlan " + plan.getClass() + " " + plan.getGamlType().getContentType());
		DEBUG.OUT("END --- ConvertAnother : BDIPlan ");
	}

	@Override
	public Object unmarshal(final HierarchicalStreamReader arg0, final UnmarshallingContext arg1) {
		return null;
	}
}