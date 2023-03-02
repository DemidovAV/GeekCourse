import java.util.ArrayList;
import java.util.List;

public class CommandList {

    private List<String> commandsList = new ArrayList<>();

    public List<String> getCommandsList() {
        commandsList.add("/addClient имя_покупателя --- добавить покупателя в базу данных");
        commandsList.add("/addProduct название_товара стоимость_товара --- добавить товар в базу данных");
        commandsList.add("/buy имя_покупателя название_товара --- организовать возможность покупки товара");
        commandsList.add("/showProductsByClient имя_покупателя --- посмотреть какие товары покупал клиент");
        commandsList.add("/findClientsByProductTitle название_товара --- какие клиенты купили определенный товар");
        commandsList.add("/removeClient имя_элемента ---  удалить из базы покупателей");
        commandsList.add("/removeProduct имя_элемента --- удалить из базы товары");
        commandsList.add("/exit --- выход");
        return commandsList;
    }
}
