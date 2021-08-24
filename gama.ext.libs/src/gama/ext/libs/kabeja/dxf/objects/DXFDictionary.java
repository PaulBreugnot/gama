/*******************************************************************************************************
 *
 * DXFDictionary.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.objects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import gama.ext.libs.kabeja.dxf.DXFConstants;


/**
 * The Class DXFDictionary.
 */
public class DXFDictionary extends DXFObject {
    
    /** The records. */
    protected ArrayList records = new ArrayList();

    public String getObjectType() {
        return DXFConstants.OBJECT_TYPE_DICTIONARY;
    }

    /**
     * Checks for DXF object by ID.
     *
     * @param id the id
     * @return true, if successful
     */
    public boolean hasDXFObjectByID(String id) {
        return findByID(id) != null;
    }

    /**
     * Gets the name for DXF object ID.
     *
     * @param id the id
     * @return the name for DXF object ID
     */
    public String getNameForDXFObjectID(String id) {
        return findByID(id).getName();
    }

    /**
     * Gets the.
     *
     * @param id the id
     * @return the DXFObject or null if there is no such DXFObject
     * @see DXFObject with the specified ID.
     */
    public DXFObject getDXFObjectByID(String id) {
        //search for child dictionaries
        DXFDictionary dic = this.getDXFDictionaryForID(id);

        if (dic != null) {
            DXFDictionaryRecord dicRecord = dic.findByID(id);

            if (dicRecord != null) {
                return dicRecord.getDXFObject();
            }
        }

        return null;
    }

    /**
     * Gets the DXF object by name.
     *
     * @param name the name
     * @return the DXF object by name
     */
    public DXFObject getDXFObjectByName(String name) {
        DXFDictionaryRecord record = findByName(name);

        if (record != null) {
            return record.getDXFObject();
        }

        return null;
    }

    /**
     * Put DXF object.
     *
     * @param obj the obj
     */
    public void putDXFObject(DXFObject obj) {
        findByID(obj.getID()).setDXFObject(obj);
    }

    /**
     * Put DXF object relation.
     *
     * @param name the name
     * @param id the id
     */
    public void putDXFObjectRelation(String name, String id) {
        DXFDictionaryRecord record = null;

        if ((record = findByName(name)) != null) {
            record.setID(id);
        } else {
            record = new DXFDictionaryRecord(name, id);
            this.records.add(record);
        }
    }

    /**
     * Find by name.
     *
     * @param name the name
     * @return the DXF dictionary record
     */
    protected DXFDictionaryRecord findByName(String name) {
        for (int i = 0; i < this.records.size(); i++) {
            DXFDictionaryRecord record = (DXFDictionaryRecord) records.get(i);

            if (record.getName().equals(name)) {
                return record;
            }
        }

        return null;
    }

    /**
     * Find by ID.
     *
     * @param id the id
     * @return the DXF dictionary record
     */
    protected DXFDictionaryRecord findByID(String id) {
        for (int i = 0; i < this.records.size(); i++) {
            DXFDictionaryRecord record = (DXFDictionaryRecord) records.get(i);

            if (record.getID().equals(id)) {
                return record;
            }
        }

        return null;
    }

    /**
     * Searches recursive for the dictionary which holds the ID.
     *
     * @param id the id
     * @return the dictionary or null
     */
    public DXFDictionary getDXFDictionaryForID(String id) {
        Set dictionaries = new HashSet();
        DXFObject obj = null;

        for (int i = 0; i < this.records.size(); i++) {
            DXFDictionaryRecord record = (DXFDictionaryRecord) records.get(i);

            if (record.getID().equals(id)) {
                return this;
            } else if (((obj = record.getDXFObject()) != null) &&
                    obj.getObjectType()
                           .equals(DXFConstants.OBJECT_TYPE_DICTIONARY)) {
                dictionaries.add(obj);
            }
        }

        Iterator ie = dictionaries.iterator();

        while (ie.hasNext()) {
            DXFDictionary dic = (DXFDictionary) ie.next();
            DXFDictionary d = dic.getDXFDictionaryForID(id);

            if (d != null) {
                return d;
            }
        }

        return null;
    }

    /**
     * Gets the DXF object iterator.
     *
     * @return iterator over all DXFObjects in this dictionary
     */
    public Iterator getDXFObjectIterator() {
        Iterator i = new Iterator() {
                int count = 0;

                public boolean hasNext() {
                    return count < records.size();
                }

                public Object next() {
                    return ((DXFDictionaryRecord) records.get(count++)).getDXFObject();
                }

                public void remove() {
                    records.remove(count - 1);
                }
            };

        return i;
    }

    /**
     * The Class DXFDictionaryRecord.
     */
    private class DXFDictionaryRecord {
        
        /** The id. */
        private String id;
        
        /** The name. */
        private String name;
        
        /** The obj. */
        private DXFObject obj;

        /**
         * Instantiates a new DXF dictionary record.
         *
         * @param name the name
         * @param id the id
         */
        public DXFDictionaryRecord(String name, String id) {
            this.id = id;
            this.name = name;
        }

        /**
         * Gets the name.
         *
         * @return the name
         */
        public String getName() {
            return this.name;
        }

        /**
         * Gets the id.
         *
         * @return the id
         */
        public String getID() {
            return this.id;
        }

        /**
         * Sets the id.
         *
         * @param id the new id
         */
        public void setID(String id) {
            this.id = id;
        }

        /**
         * Sets the DXF object.
         *
         * @param obj the new DXF object
         */
        public void setDXFObject(DXFObject obj) {
            this.obj = obj;
        }

        /**
         * Gets the DXF object.
         *
         * @return the DXF object
         */
        public DXFObject getDXFObject() {
            return this.obj;
        }
    }
}
