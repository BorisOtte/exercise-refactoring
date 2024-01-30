package nl.han.ica.oose.dea;

public class OrdersWriter {
    private Orders orders;
    private String ordersString;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
        this.ordersString = ordersToString(orders);
    }

    public String getContents(){
        return ordersString;
    }

    private String ordersToString(Orders orders) {
        var stringBuilder = new StringBuilder("{\"orders\": [");

        // For each order
        for (int i = 0; i < orders.getOrdersCount(); i++) {
            Order order = orders.getOrder(i);
            stringBuilder.append("{\"id\": ")
                .append(order.getOrderId())
                .append(", \"products\": [");

            // For each product in an order
            for (int j = 0; j < order.getProductsCount(); j++) {
                Product product = order.getProduct(j);

                stringBuilder.append("{\"code\": \"")
                        .append(product.getCode())
                        .append("\", \"color\": \"")
                        .append(product.getColorString())
                        .append("\", ");

                if (product.getSize() != -1) {
                    stringBuilder.append("\"size\": \"")
                            .append(product.getSizeString())
                            .append("\", ");
                }

                stringBuilder.append("\"price\": ")
                        .append(product.getPrice())
                        .append(", \"currency\": \"")
                        .append(product.getCurrency())
                        .append("\"}, ");
            }

            //Get rid of something?
            if (order.getProductsCount() > 0) {
                int length = stringBuilder.length();
                stringBuilder.delete(length - 2, length);
            }

            stringBuilder.append("]}, ");
        }

        //Get rid of something?
        if (orders.getOrdersCount() > 0) {
            int length = stringBuilder.length();
            stringBuilder.delete(length - 2, length);
        }

        return stringBuilder.append("]}").toString();
    }
}
