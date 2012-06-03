package net.sf.persist;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Abstract class to handle tracking property changes in your data objects.
 * This is not required to persist your data objects however subclassing from
 * PersistableObject will mean that only changed properties will be written
 * back to the database.
 *
 * @author Dan Howard
 * @since Dec 3, 2010 9:30:45 PM
 */
public abstract class PersistableObject {

    Object originalValue = null;

    final void saveReadState() throws PersistException {
        try {
            if (originalValue == null) {
                Map[] map = Mapping.getFieldsMaps(getClass());
                Map<String, Method> getters = map[1];
                Map<String, Method> setters = map[2];

                originalValue = getClass().newInstance();
                for (String key : getters.keySet()) {
                    setters.get(key).invoke(originalValue, getters.get(key).invoke(this));
                }
            }
        } catch (Exception e) {
            throw new PersistException(e.getMessage(), e);
        }
    }

}
