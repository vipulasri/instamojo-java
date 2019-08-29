package com.instamojo.wrapper.api;

import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.HTTPException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.model.PaymentOrderResponse;
import com.instamojo.wrapper.model.Refund;
import com.instamojo.wrapper.response.ApiListResponse;

import java.util.Date;


public class InstamojoExample {

    public static void main(String args[]) {

        /*
         * Get a reference to the instamojo api
         */
        ApiContext context = ApiContext.create("test_HFPivnZqm3zYzjdrmrq5L1MXrb45Gk6IK47",
                "test_yXfTNXFXXZn385MbA9ajwX2Ji02ipvNpVwognz2ogTdVLoVdx5B6Kkc00pGwB67cUlzMw0kft82ZHDI5S3WoTMNv1PV4fIV924yyKmOKluQzrlixfulpDv2PTBH",
                ApiContext.Mode.TEST);
        Instamojo api = new InstamojoImpl(context);

        /*
         * Create a new payment order
         */
        PaymentOrder order = new PaymentOrder();
        order.setName("John Smith");
        order.setEmail("john.smith@gmail.com");
        order.setPhone("1234567890");
        order.setCurrency("INR");
        order.setAmount(9D);
        order.setDescription("This is a test transaction.");
        order.setRedirectUrl("http://www.someexample.com");
        order.setWebhookUrl("http://www.someurl.com/");
        order.setTransactionId("dxg432");
        //order.setExpiresAt(new Date());
        //order.setAllowRepeatedPayments(true);

        System.out.println(order);

        try {
            PaymentOrderResponse paymentOrderResponse = api.createPaymentOrder(order);
            System.out.println(paymentOrderResponse.getPaymentOrder());

        } catch (HTTPException e) {
            System.out.println(e.getStatusCode());
            System.out.println(e.getMessage());
            System.out.println(e.getJsonPayload());

        } catch (ConnectionException e) {
            System.out.println(e.getMessage());
        }

        /*
         * Get details of payment order when order id is given
         */
        /*try {
            PaymentOrder paymentOrder = api.getPaymentOrder("[PAYMENT_ORDER_ID]");
            System.out.println(paymentOrder.getId());
            System.out.println(paymentOrder.getStatus());

        } catch (HTTPException e) {
            System.out.println(e.getStatusCode());
            System.out.println(e.getMessage());
            System.out.println(e.getJsonPayload());

        } catch (ConnectionException e) {
            System.out.println(e.getMessage());
        }*/

        /*
         * Get details of payment order when transaction id is given
         */
        /*try {
            PaymentOrder paymentOrder = api.getPaymentOrderByTransactionId("[TRANSACTION_ID]");
            System.out.println(paymentOrder.getId());
            System.out.println(paymentOrder.getStatus());

        } catch (HTTPException e) {
            System.out.println(e.getStatusCode());
            System.out.println(e.getMessage());
            System.out.println(e.getJsonPayload());

        } catch (ConnectionException e) {
            System.out.println(e.getMessage());
        }*/

        /*
         * Get list of all payment orders
         */
        /*try {
            ApiListResponse<PaymentOrder> paymentOrders = api.getPaymentOrders(0, 10);

            // Loop over all of the payment orders and print status of each
            // payment order.
            for (PaymentOrder paymentOrder : paymentOrders.getResults()) {
                System.out.println("Result = " + paymentOrder.getStatus());
            }
            System.out.println(paymentOrders);

        } catch (HTTPException e) {
            System.out.println(e.getStatusCode());
            System.out.println(e.getMessage());
            System.out.println(e.getJsonPayload());

        } catch (ConnectionException e) {
            System.out.println(e.getMessage());
        }*/


        /*
         * Create a new refund
         */
        /*Refund refund = new Refund();
        refund.setPaymentId("[PaymentId]");
        refund.setStatus("refunded");
        refund.setType("RFD");
        refund.setBody("This is a test refund.");
        refund.setRefundAmount(9D);
        refund.setTotalAmount(10D);

        try {
            Refund createdRefund = api.createRefund(refund);
            System.out.println(createdRefund.getId());
            System.out.println(createdRefund.getStatus());

        } catch (HTTPException e) {
            System.out.println(e.getStatusCode());
            System.out.println(e.getMessage());
            System.out.println(e.getJsonPayload());

        } catch (ConnectionException e) {
            System.out.println(e.getMessage());
        }*/
    }
}
