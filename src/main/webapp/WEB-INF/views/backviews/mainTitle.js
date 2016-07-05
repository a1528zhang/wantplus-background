/**
 * Created by a1528zhang on 2016/5/20.
 */
/**
 * 主菜单分类名称和icon
 */
import {Component} from 'react';
import {Icon} from 'antd';

class MainTitle extends Component{
    render(){
        let iconClass = this.props.iconClass;
        let icon;
        if (iconClass == "user"){
            icon = <Icon type="user" />;
        };
        if  (iconClass == "goods"){
            icon = <Icon type="shopping-cart" />;
        }
        return (
            <div className="want-main-title" aria-hidden="true">
                &nbsp;&nbsp;{icon}&nbsp;{this.props.title}
            </div>
        );
    }
};

export default MainTitle;