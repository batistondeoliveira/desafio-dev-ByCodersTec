import { format } from 'date-fns';
import { pt } from 'date-fns/locale';
import { zonedTimeToUtc } from 'date-fns-tz';

export const DateFormat = (data, formato) => 
  format( zonedTimeToUtc(data, 'America/Sao_Paulo'), formato, {locale: pt} )