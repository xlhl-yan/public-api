import {PageContainer,} from '@ant-design/pro-components';
import React, {useEffect, useState} from 'react';
import ReactECharts from 'echarts-for-react';
import {listTopInvokeInterfaceInfoUsingGET} from "@/services/public-api/analyseController";

const InterfaceAnalyse: React.FC = () => {
  const [data, setData] = useState<API.InterfaceInfoVO[]>([]);
  const [loading, setLoading] = useState(true);
  const top = 10;
  useEffect(() => {
    try {
      listTopInvokeInterfaceInfoUsingGET({top}).then(res => {
          if (res.data) {
            setData(res.data);
          }
        }
      )
    } catch (error: any) {

    }
  }, [])
  /**
   * 映射
   */
  const charData = data.map(item => {
    return {
      value: item.totalNum,
      name: item.name
    }
  });

  /**
   * 接口分析
   */
  const option = {
    title: {
      text: '调用最多的接口 Top' + top,
      left: 'center'
    },
    tooltip: {
      trigger: 'item'
    },
    legend: {
      orient: 'vertical',
      left: 'left'
    },
    series: [
      {
        name: 'Access From',
        type: 'pie',
        radius: '50%',
        data: charData,
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
          }
        }
      }
    ]
  };
  return (
    <PageContainer>
      <ReactECharts loadingOption={{showLoading: loading}} option={option}/>
    </PageContainer>
  )
}
export default InterfaceAnalyse;
