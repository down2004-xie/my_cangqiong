package main.java.com.sky.service;

import com.sky.dto.OrdersDTO;
import com.sky.entity.Orders;

/**
 * AI订单调度Agent服务接口
 * 
 * 基于大语言模型驱动的智能订单调度系统，包含订单分析、智能分配、异常处理等核心能力
 */
public interface OrderDispatchAgentService {

    /**
     * 智能分配订单给骑手
     * 通过强化学习算法结合实时数据动态分配最优骑手
     * 
     * @param order 订单信息
     * @return 分配结果JSON
     */
    String dispatchOrder(Orders order);

    /**
     * 分析订单内容（LLM驱动）
     * 通过大语言模型解析订单文本信息，提取关键特征并分类标记
     * 
     * @param ordersDTO 订单DTO
     * @return 分析结果JSON
     */
    String analyzeOrderContent(OrdersDTO ordersDTO);

    /**
     * 处理异常订单
     * 实时监控配送状态，自动触发重分配流程
     * 
     * @param orderId 订单ID
     * @return 处理结果
     */
    String handleExceptionOrder(Long orderId);

    /**
     * 实时监控配送状态
     * 多Agent协作监控，检测超时风险并预警
     * 
     * @param orderId 订单ID
     * @return 配送状态JSON
     */
    String monitorDeliveryStatus(Long orderId);

    /**
     * 生成配送状态通知文案（NLG）
     * 通过自然语言生成向客户推送友好的状态通知
     * 
     * @param orderId 订单ID
     * @param status 配送状态
     * @return 通知文案
     */
    String generateDeliveryNotification(Long orderId, String status);
}
