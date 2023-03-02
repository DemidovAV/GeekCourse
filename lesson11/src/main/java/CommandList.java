import java.util.ArrayList;
import java.util.List;

public class CommandList {

    private List<String> commandsList = new ArrayList<>();

    public List<String> getCommandsList() {
        commandsList.add("/addClient ���_���������� --- �������� ���������� � ���� ������");
        commandsList.add("/addProduct ��������_������ ���������_������ --- �������� ����� � ���� ������");
        commandsList.add("/buy ���_���������� ��������_������ --- ������������ ����������� ������� ������");
        commandsList.add("/showProductsByClient ���_���������� --- ���������� ����� ������ ������� ������");
        commandsList.add("/findClientsByProductTitle ��������_������ --- ����� ������� ������ ������������ �����");
        commandsList.add("/removeClient ���_�������� ---  ������� �� ���� �����������");
        commandsList.add("/removeProduct ���_�������� --- ������� �� ���� ������");
        commandsList.add("/exit --- �����");
        return commandsList;
    }
}
