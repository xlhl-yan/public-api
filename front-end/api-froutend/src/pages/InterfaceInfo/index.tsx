import {
  getInterfaceInfoByIdUsingGET,
  invokeInterfaceInfoUsingPOST,
} from '@/services/public-api/interfaceInfoController';
import { PageContainer } from '@ant-design/pro-components';
import { Button, Card, Descriptions, Divider, Form, Input, message } from 'antd';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router';

/**
 * 主页
 * @constructor
 */
const Index: React.FC = () => {
  const [loading, setLoading] = useState(false);
  const [invokeLoading, setInvokeLoading] = useState(false);
  const [data, setData] = useState<API.InterfaceInfo>();
  const [invokeRes, setInvokeRes] = useState<any>();
  const params = useParams();
  const pageSizeInit = 5;

  const onFinish = async (values: any) => {
    setInvokeLoading(true);
    try {
      if (!params.id) {
        message.error('接口不存在');
      }
      const res = await invokeInterfaceInfoUsingPOST({
        id: params.id,
        ...values,
      });
      setInvokeRes(res.data);
    } catch (error: any) {
      message.error('调用失败' + error.message);
      return false;
    }
    setInvokeLoading(false);
  };
  const loadData = async () => {
    setLoading(true);
    if (!params.id) {
      message.error('参数不存在');
    }
    try {
      const res = await getInterfaceInfoByIdUsingGET({
        id: Number(params.id),
      });

      setData(res.data);
    } catch (error: any) {
      message.error('加载数据失败' + error.message);
      return false;
    }
    setLoading(false);
  };

  useEffect(() => {
    loadData();
  }, []);

  return (
    <PageContainer title={'查看接口文档'}>
      <Card title={'接口详情'}>
        {data ? (
          <Descriptions title={data?.name} column={1}>
            <Descriptions.Item label={'请求地址'}>{data.url}</Descriptions.Item>
            <Descriptions.Item label={'接口状态'}>
              {data.status ? '正常' : '暂停维护'}
            </Descriptions.Item>
            <Descriptions.Item label={'描述'}>{data.description}</Descriptions.Item>
            <Descriptions.Item label={'请求方法'}>{data.method}</Descriptions.Item>
            <Descriptions.Item label={'请求参数'}>{data.requestParams}</Descriptions.Item>
            <Descriptions.Item label={'请求头'}>{data.requestHeader}</Descriptions.Item>
            <Descriptions.Item label={'响应头'}>{data.responseHeader}</Descriptions.Item>
            <Descriptions.Item label={'上线时间'}>
              {new Date(data.createTime).toLocaleDateString()}
            </Descriptions.Item>
            <Descriptions.Item label={'更新时间'}>
              {new Date(data.updateTime).toLocaleDateString()}
            </Descriptions.Item>
          </Descriptions>
        ) : (
          <>接口不存在</>
        )}
      </Card>
      <Divider />
      <Card title={'在线测试'}>
        <Form layout="vertical" name="invoke" onFinish={onFinish}>
          <Form.Item label="请求参数" name="userRequestParams">
            <Input.TextArea />
          </Form.Item>

          <Form.Item>
            <Button type="primary" htmlType="submit">
              调用
            </Button>
          </Form.Item>
        </Form>
      </Card>
      <Divider />
      <Card title={'调用结果'} loading={invokeLoading}>
        {invokeRes}
      </Card>
    </PageContainer>
  );
};
export default Index;
