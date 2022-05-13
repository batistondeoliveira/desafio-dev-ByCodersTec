import { CurrencyFormat, DateFormat } from '../Utils';

var ColumnTypeEnum = {
  TEXT: {
    enumName: 'TEXT',        
    format: function(value) {
      return value;
    }
  },
  CURRENCY: {
    enumName: 'CURRENCY',        
    format: function(value) {
      return CurrencyFormat(value);
    }
  },
  DATE: {
    enumName: 'DATE',        
    format: (value) => { 
      return DateFormat(value, "dd/MM/yyyy");
    }
  },
  get(value) {              
    if(value === null)
      return ColumnTypeEnum.TEXT;

    var array = Object.values(ColumnTypeEnum);
    var found = {};

    array.forEach(element => {            
      if(element.enumName === value) {
        found = element;      
        return ;          
      }            
    });   
    
    return found;
  }
}

export default ColumnTypeEnum;
