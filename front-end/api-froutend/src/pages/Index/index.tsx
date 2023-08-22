import { listInterfaceInfoByPageUsingGET } from '@/services/public-api/interfaceInfoController';
import { PageContainer } from '@ant-design/pro-components';
import { List, message } from 'antd';
import React, { useEffect, useState } from 'react';

/**
 * 主页
 * @constructor
 */
const Index: React.FC = () => {
  const [loading, setLoading] = useState(false);
  const [list, setList] = useState<API.InterfaceInfo[]>([]);
  const [total, setTotal] = useState<number>(0);
  const pageSizeInit = 5;
  const loadData = async (current = 1, pageSize = pageSizeInit) => {
    setLoading(true);
    try {
      const res = await listInterfaceInfoByPageUsingGET({
        //todo 参数
      });
      setList(res.data?.records ?? []);
      setTotal(res.data?.total ?? 0);
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
    <PageContainer title={'在线接口开放平台'}>
      <List
        className="demo-loadmore-list"
        loading={loading}
        itemLayout="horizontal"
        dataSource={list}
        renderItem={(item) => {
          const apiLink = `/interfaceInfo/${item.id}`;
          return (
            <List.Item
              actions={[
                <a key={item.id} href={apiLink}>
                  查看
                </a>,
              ]}
            >
              <List.Item.Meta
                title={<a href={apiLink}>{item.name}</a>}
                description={item.description}
              />
            </List.Item>
          );
        }}
        pagination={{
          showTotal(total: number) {
            return '总数：' + total;
          },
          pageSize: pageSizeInit,
          total,
          onChange(current, pageSize) {
            loadData(current, pageSize);
          },
        }}
      />
    </PageContainer>
  );
};
export default Index;
