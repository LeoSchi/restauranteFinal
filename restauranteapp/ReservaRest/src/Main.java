import br.edu.up.controller.ReservaController;
import br.edu.up.daos.ReservaDAO;
import br.edu.up.view.ReservaView;

public class Main {
    public static void main(String[] args) {
        ReservaDAO reservaDAO = new ReservaDAO();
        ReservaView reservaView = new ReservaView();
        ReservaController reservaController = new ReservaController(reservaDAO, reservaView);
        reservaController.iniciar();
    }
}
