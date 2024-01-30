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
                int productSize = product.getSize();
                String productColor = getColorFor(product.getColor());

                stringBuilder.append("{\"code\": \"")
                        .append(product.getCode())
                        .append("\", \"color\": \"")
                        .append(productColor)
                        .append("\", ");

                if (productSize != -1) {
                    stringBuilder.append("\"size\": \"")
                            .append(getSizeFor(productSize))
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
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            }

            stringBuilder.append("]");
            stringBuilder.append("}, ");
        }

        //Get rid of something?
        if (orders.getOrdersCount() > 0) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }

        return stringBuilder.append("]}").toString();
    }

    private String getSizeFor(int size) {
        return switch (size) {
            case 1 -> "XS";
            case 2 -> "S";
            case 3 -> "M";
            case 4 -> "L";
            case 5 -> "XL";
            case 6 -> "XXL";
            default -> "Invalid Size";
        };
    }

    private String getColorFor(int color) {
        return switch (color) {
            case 1 -> "blue";
            case 2 -> "red";
            case 3 -> "yellow";
            default -> "no color";
        };
    }
}
