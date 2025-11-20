package fish.payara.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import fish.payara.domain.Item;
import fish.payara.service.ItemService;

@FacesConverter(value = "itemConverter", managed = true)
public class ItemConverter implements Converter<Item> {

    @Inject
    private ItemService itemService;

    @Override
    public Item getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return itemService.find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Item item) {
        if (item == null || item.getItemId() == null) {
            return "";
        }
        return item.getItemId().toString();
    }
}