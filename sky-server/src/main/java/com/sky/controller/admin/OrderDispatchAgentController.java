package com.sky.controller.admin;

import com.sky.dto.OrdersDTO;
import com.sky.entity.Orders;
import com.sky.result.Result;
import com.sky.service.OrderDispatchAgentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * AI订单调度Agent控制器
 * 
 * 提供智能订单调度、订单分析、异常处理等AI驱动功能的REST API
 */
@Slf4j
@RestController
@RequestMapping("/admin/order-dispatch")
@Api(tags = "AI订单调度Agent接口")
public class OrderDispatchAgentController {

    @Autowired
    private OrderDispatchAgentService orderDispatchAgentService;

    /**
     * 智能分配订单
     */
    @PostMapping("/dispatch")
    @ApiOperation("智能分配订单给骑手")
    public Result<String> dispatchOrder(@RequestBody Orders order) {
        log.info("智能分配订单请求: {}", order.getId());
        String result = orderDispatchAgentService.dispatchOrder(order);
        return Result.success(result);
    }

    /**
     * 分析订单内容
     */
    @PostMapping("/analyze")
    @ApiOperation("LLM分析订单内容")
    public Result<String> analyzeOrder(@RequestBody OrdersDTO ordersDTO) {
        log.info("LLM分析订单请求: {}", ordersDTO.getId());
        String result = orderDispatchAgentService.analyzeOrderContent(ordersDTO);
        return Result.success(result);
    }

    /**
     * 处理异常订单
     */
    @PostMapping("/exception/{orderId}")
    @ApiOperation("处理异常订单")
    public Result<String> handleException(@PathVariable Long orderId) {
        log.info("处理异常订单请求: {}", orderId);
        String result = orderDispatchAgentService.handleExceptionOrder(orderId);
        return Result.success(result);
    }

    /**
     * 监控配送状态
     */
    @GetMapping("/monitor/{orderId}")
    @ApiOperation("实时监控配送状态")
    public Result<String> monitorStatus(@PathVariable Long orderId) {
        log.info("监控配送状态请求: {}", orderId);
        String result = orderDispatchAgentService.monitorDeliveryStatus(orderId);
        return Result.success(result);
    }

    /**
     * 生成配送通知
     */
    @GetMapping("/notification/{orderId}/{status}")
    @ApiOperation("生成配送通知文案")
    public Result<String> generateNotification(
            @PathVariable Long orderId, 
            @PathVariable String status) {
        log.info("生成配送通知请求: orderId={}, status={}", orderId, status);
        String result = orderDispatchAgentService.generateDeliveryNotification(orderId, status);
        return Result.success(result);
    }
}