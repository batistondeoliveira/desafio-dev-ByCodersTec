import React from 'react';
import AlignEnum from './AlignEnum.js';
import ColumnTypeEnum from './ColumnTypeEnum.js';

const Table = ({ head, body, footer }) => {  
  const align = (itemHead) => {
    if(itemHead.align === undefined)
      return AlignEnum.LEFT.className;

    return itemHead.align.className;
  }    

  const showField = (item, itemHead) => {
    if(itemHead.type === undefined) {            
      return item[itemHead.fieldName];
    }
    
    let tableType = ColumnTypeEnum.get(itemHead.type.enumName);      
            
    return tableType.format(item[itemHead.fieldName]); 
  }
          
  return (        
    <table rules="rows">
      <thead>
        <tr>
          {head.map((item, i) =>                   
            <th 
              key={i}
              className={align(item)}
              width={item.width}
            >
              {item.title}
            </th>                  
          )}              
        </tr>
      </thead>
      <tbody>
        {Array.isArray(body) && body.map((item, index) =>               
          <tr key={index}>
            {head.map((itemHead, i) =>                      
              <td 
                key={i} 
                className={align(itemHead)}
              >
                {showField(item, itemHead)}
              </td>                      
            )}                  
          </tr>              
        )}
      </tbody>
      {footer}
    </table>            
  )    
}

export default  Table;