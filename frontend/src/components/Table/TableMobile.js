import React from 'react';
import ColumnTypeEnum from './ColumnTypeEnum';

const TableMobile = ({ head, body }) => {
  const showField = (itemHead) => {
    if(itemHead.type === undefined) {            
      return body[itemHead.fieldName];
    }
    
    let tableType = ColumnTypeEnum.get(itemHead.type.enumName);      
            
    return tableType.format(body[itemHead.fieldName]); 
  }

  return (
    <>
      {head.map((item, index) => 
        <div key={index} className="rel-container">
          <div className="rel-container-titulo">
            {item.title}:
          </div>
          <div className="rel-container-dado">
            {showField(item)}            
          </div>
        </div>
      )}
    </>  
  )
}

export default TableMobile;
