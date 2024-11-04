public class Main {
    public static void main(String[] args) {
        DishDAO dishDAO = new DishDAO();

        // Thêm món ăn mới
        dishDAO.addDish("Pizza", 10.5);

        // Lấy danh sách món ăn
        List<Dish> dishes = dishDAO.getAllDishes();
        for (Dish dish : dishes) {
            System.out.println("ID: " + dish.getId() + ", Name: " + dish.getName() + ", Price: " + dish.getPrice());
        }

        // Xóa món ăn với ID = 1
        dishDAO.deleteDish(1);
    }
}
