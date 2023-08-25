// @ts-ignore
/* eslint-disable */
import { request } from '@umijs/max';

/** listTopInvokeInterfaceInfo GET /api/analyse/top/interface/invoke */
export async function listTopInvokeInterfaceInfoUsingGET(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.listTopInvokeInterfaceInfoUsingGETParams,
  options?: { [key: string]: any },
) {
  return request<API.BaseResponseListInterfaceInfoVO>('/api/analyse/top/interface/invoke', {
    method: 'GET',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}
