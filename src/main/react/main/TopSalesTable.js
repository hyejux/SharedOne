// src/components/TopSalesTable.js
import React, {useEffect} from 'react';

const TopSalesTable = ({data}) => {
    console.log(data);

    return (
        <table className="table">
            <thead>
            <tr>
                <th>순위</th>
                <th>이름</th>
                <th>매출액</th>
            </tr>
            </thead>
            <tbody>
            {data.map((item, index) => (
                // JSX를 반환하는 부분에 return이 생략되었기 때문에 아래처럼 수정해야 합니다
                <tr key={index}>
                    <td>{index + 1}</td>
                    <td>{'employeeName' in item ? item.employeeName : item.productName}</td>
                    <td>{item.monthlySales}</td>
                </tr>
            ))}
            </tbody>
        </table>
    );
};

export default TopSalesTable;
